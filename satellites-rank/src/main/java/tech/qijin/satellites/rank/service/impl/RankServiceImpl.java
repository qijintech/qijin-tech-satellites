package tech.qijin.satellites.rank.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.satellites.rank.service.RankService;
import tech.qijin.satellites.rank.service.bo.RankingBo;
import tech.qijin.satellites.rank.service.helper.RankHelper;
import tech.qijin.util4j.redis.RedisUtil;
import tech.qijin.util4j.timezone.TimezoneHandler;
import tech.qijin.util4j.trace.util.ChannelUtil;
import tech.qijin.util4j.utils.DateUtil;
import tech.qijin.util4j.utils.TimezoneUtil;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author michealyang
 * @date 2019/1/6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Slf4j
@Service
public class RankServiceImpl implements RankService {

    protected static final String MONTH_PATTERN = "yyyyMM";
    protected static final String YEAR_PATTERN = "yyyy";

    @Autowired
    private RankHelper commentHelper;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private TimezoneHandler timezoneHandler;

    @Override
    public void fire(String field, Long score) {
        DateTime dateTime = timezoneHandler.coordinate(DateUtil.now());
        String dailyKey = getDailyKey(dateTime);
        redisUtil.zAdd(dailyKey, field, score);
        String weeklyKey = getWeeklyKey(dateTime);
        redisUtil.zAdd(weeklyKey, field, score);
        String monthlyKey = getMonthlyKey(dateTime);
        redisUtil.zAdd(monthlyKey, field, score);
        String yearlyKey = getYearlyKey(dateTime);
        redisUtil.zAdd(yearlyKey, field, score);
    }

    @Override
    public void fire(String field, Long score, Set<Dimension> dimensions) {

    }

    @Override
    public List<RankingBo> dailyRank() {
        return null;
    }

    @Override
    public List<RankingBo> weeklyRank() {
        return null;
    }

    @Override
    public List<RankingBo> monthlyRank() {
        return null;
    }

    @Override
    public List<RankingBo> yearlyRank() {
        return null;
    }

    private String getDailyKey() {
        DateTime now = timezoneHandler.coordinate(DateUtil.now());
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
}
