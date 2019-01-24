package tech.qijin.satellites.favorites.service.helper.impl;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.satellites.favorites.db.dao.FaFavoritesDao;
import tech.qijin.satellites.favorites.db.model.FaFavorites;
import tech.qijin.satellites.favorites.db.model.FaFavoritesExample;
import tech.qijin.satellites.favorites.service.helper.FavoritesHelper;
import tech.qijin.util4j.aop.util.CasAssert;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.trace.pojo.Channel;
import tech.qijin.util4j.trace.util.ChannelUtil;
import tech.qijin.util4j.utils.MAssert;
import tech.qijin.util4j.utils.NumberUtil;
import tech.qijin.util4j.web.util.PageHelperProxy;

import java.util.List;
import java.util.Optional;

/**
 * @author michealyang
 * @date 2019/1/10
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Service
@Slf4j
public class FavoritesHelperImpl implements FavoritesHelper {
    @Autowired
    private FaFavoritesDao favoritesDao;

    /**
     * 允许有重复记录，只取最新的一条
     *
     * @param userId
     * @param itemId
     * @return
     */
    @Override
    public Optional<FaFavorites> getFavorites(Long userId, Long itemId) {
        Channel channel = ChannelUtil.getChannel();
        FaFavoritesExample example = new FaFavoritesExample();
        example.setOrderByClause("id desc");
        example.or().andUserIdEqualTo(userId)
                .andChannelEqualTo(channel)
                .andItemIdEqualTo(itemId);
        List<FaFavorites> favoritesList = PageHelper.offsetPage(0, 1).doSelectPage(
                () -> favoritesDao.selectByExample(example)
        );
        return favoritesList.stream().findFirst();
    }

    @Override
    public List<FaFavorites> pageFavorites(Long userId) {
        FaFavoritesExample example = new FaFavoritesExample();
        example.or().andChannelEqualTo(ChannelUtil.getChannel())
                .andUserIdEqualTo(userId)
                .andCollectEqualTo(true)
                .andIdLessThan(PageHelperProxy.getMaxId())
                .andIdGreaterThan(PageHelperProxy.getMinId());
        return PageHelper.getLocalPage().doSelectPage(
                () -> favoritesDao.selectByExample(example)
        );
    }

    @Override
    public void insertFavorites(FaFavorites favorites) {
        checkFavorites(favorites);
        favoritesDao.insertSelective(favorites);
    }

    @Override
    public void setCollect(FaFavorites favorites, boolean collect) {
        FaFavorites record = new FaFavorites();
        record.setId(favorites.getId());
        record.setCollect(collect);
        record.setVersion(favorites.getVersion() + 1);

        FaFavoritesExample example = new FaFavoritesExample();
        example.or().andIdEqualTo(favorites.getId())
                .andChannelEqualTo(ChannelUtil.getChannel())
                .andVersionEqualTo(favorites.getVersion());
        CasAssert.isTrue(favoritesDao.updateByExampleSelective(record, example) == 1);
    }

    private void checkFavorites(FaFavorites favorites) {
        MAssert.notNull(favorites, ResEnum.INVALID_PARAM);
        MAssert.isTrue(NumberUtil.gtZero(favorites.getUserId()), ResEnum.INVALID_EMAIL);
        MAssert.isTrue(NumberUtil.gtZero(favorites.getItemId()), ResEnum.INVALID_EMAIL);
        favorites.setChannel(ChannelUtil.getChannel());
        favorites.setCollect(true);
    }
}
