package tech.qijin.satellites.rank.service.impl;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import tech.qijin.satellites.rank.service.RankService;
import tech.qijin.satellites.rank.service.bo.RankingBo;
import tech.qijin.satellites.rank.service.helper.RankHelper;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.redis.RedisUtil;
import tech.qijin.util4j.timezone.TimezoneHandler;
import tech.qijin.util4j.trace.util.ChannelUtil;
import tech.qijin.util4j.utils.DateUtil;
import tech.qijin.util4j.utils.MAssert;
import tech.qijin.util4j.utils.NumberUtil;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author michealyang
 * @date 2019/1/6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Slf4j
@Service
public class RankServiceImpl implements RankService {

    private static final String MONTH_PATTERN = "yyyyMM";
    private static final String YEAR_PATTERN = "yyyy";
    private static final Integer DEFAULT_OFFSET = 20;
    private static final Integer MAX_OFFSET = 100;

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private TimezoneHandler timezoneHandler;

    @Override
    public void fire(String member, Long score) {
        fire(member, score, Sets.newHashSet(Dimension.values()));
    }

    @Override
    public void fire(String member, Long score, Set<Dimension> dimensions) {
        DateTime dateTime = new DateTime();
        if (dimensions.contains(Dimension.DAILY)) {
            String dailyKey = getDailyKey(dateTime);
            redisUtil.zIncrby(dailyKey, member, score);
        }
        if (dimensions.contains(Dimension.WEEKLY)) {
            String weeklyKey = getWeeklyKey(dateTime);
            redisUtil.zIncrby(weeklyKey, member, score);
        }
        if (dimensions.contains(Dimension.MONTHLY)) {
            String monthlyKey = getMonthlyKey(dateTime);
            redisUtil.zIncrby(monthlyKey, member, score);
        }
        if (dimensions.contains(Dimension.YEARLY)) {
            String yearlyKey = getYearlyKey(dateTime);
            redisUtil.zIncrby(yearlyKey, member, score);
        }
    }

    public List<RankingBo> pageRank(Integer start, Integer offset, Dimension dimension) {
        start = checkStart(start);
        offset = checkOffset(offset);
        DateTime dateTime = new DateTime();
        String key;
        switch (dimension) {
            case DAILY:
                key = getDailyKey(dateTime);
            case WEEKLY:
                key = getWeeklyKey(dateTime);
            case MONTHLY:
                key = getMonthlyKey(dateTime);
            case YEARLY:
                key = getYearlyKey(dateTime);
            default:
                key = getDailyKey(dateTime);
        }
        Set<ZSetOperations.TypedTuple<String>> sets = redisUtil.zReverseRangeWithScore(key, start, start + offset);
        if (CollectionUtils.isEmpty(sets)) {
            return Collections.emptyList();
        }
        MAssert.isTrue((sets.size() & 0x01) == 0, ResEnum.BAD_GATEWAY);

        return sets.stream()
                .map(tuple -> new RankingBo(tuple.getValue(), tuple.getScore().longValue()))
                .collect(Collectors.toList());
    }

    private String getDailyKey() {
        DateTime now = new DateTime();
        String dateDay = getDateDay(now);
        return ChannelUtil.getChannel().name() + ".ranking.daily." + dateDay;
    }

    private String getDailyKey(DateTime dateTime) {
        String dateDay = getDateDay(dateTime);
        return ChannelUtil.getChannel().name() + ".ranking.daily." + dateDay;
    }

    private String getWeeklyKey(DateTime dateTime) {
        String dateWeek = getDateWeek(dateTime);
        return ChannelUtil.getChannel().name() + ".ranking.weekly." + dateWeek;
    }

    private String getMonthlyKey(DateTime dateTime) {
        String dateMonth = getDateMonth(dateTime);
        return ChannelUtil.getChannel().name() + ".ranking.monthly." + dateMonth;
    }

    private String getYearlyKey(DateTime dateTime) {
        String dateYear = getDateYear(dateTime);
        return ChannelUtil.getChannel().name() + ".ranking.yearly." + dateYear;
    }

    public String getDateDay(DateTime dateTime) {
        return dateTime.toString(DateUtil.YYYYMMDD);
    }

    /**
     * 返回date所代表year的第几周。自动转换成指定时区
     * <p>如201901表示2019年第1周</p>
     * 需要DateTime类型包含正确的时区信息
     *
     * @param dateTime
     * @return
     */
    public String getDateWeek(DateTime dateTime) {
        int week = timezoneHandler.getWeekOfYear(dateTime);
        return new StringBuilder().append(timezoneHandler.getYear(dateTime))
                .append(StringUtils.leftPad(String.valueOf(week), 2, '0'))
                .toString();
    }

    /**
     * 返回月份。自动转换成指定时区
     * <p>如201901</p>
     * 需要DateTime类型包含正确的时区信息
     *
     * @param dateTime
     * @return
     */
    public String getDateMonth(DateTime dateTime) {
        return dateTime.toString(MONTH_PATTERN);
    }

    public String getDateYear(DateTime dateTime) {
        return dateTime.toString(YEAR_PATTERN);
    }

    private Integer checkStart(Integer start) {
        return start == null ? 0 : start;
    }

    private Integer checkOffset(Integer offset) {
        if (NumberUtil.nullOrLeZero(offset)) {
            return DEFAULT_OFFSET;
        }
        if (offset > MAX_OFFSET) {
            return MAX_OFFSET;
        }
        return offset;
    }

    public static void main(String[] args) {
        Double x = 234.234d;
        System.out.print(x.longValue());
    }
}
