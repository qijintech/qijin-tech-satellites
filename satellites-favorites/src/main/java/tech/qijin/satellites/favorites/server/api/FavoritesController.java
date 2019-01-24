package tech.qijin.satellites.favorites.server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.qijin.satellites.favorites.server.vo.FavoriteReqVo;
import tech.qijin.satellites.favorites.server.vo.FavoritesResVo;
import tech.qijin.satellites.favorites.service.FavoritesService;
import tech.qijin.satellites.favorites.service.bo.FavoritesBo;
import tech.qijin.satellites.favorites.service.spi.SpiService;
import tech.qijin.util4j.web.annotation.ChannelRequired;
import tech.qijin.util4j.web.pojo.ResultVo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author michealyang
 * @date 2019/1/10
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@RestController
@RequestMapping("/favorites")
public class FavoritesController {
    @Autowired
    private FavoritesService favoritesService;
    @Autowired
    private SpiService spiService;

    @ChannelRequired
    @PostMapping("/do")
    public ResultVo doFavorites(@RequestBody FavoriteReqVo favoriteReqVo) {
        favoritesService.doFavorites(favoriteReqVo.getItemId());
        return ResultVo.instance().success();
    }

    @ChannelRequired
    @PostMapping("/cancel")
    public ResultVo cancelFavorites(@RequestBody FavoriteReqVo favoriteReqVo) {
        favoritesService.cancelFavorites(favoriteReqVo.getItemId());
        return ResultVo.instance().success();
    }

    @ChannelRequired
    @GetMapping("/list")
    public List<FavoritesResVo> pageFavorites() {
        List<FavoritesBo> favoritesBos = spiService.pageFavorites();
        return favoritesBos.stream()
                .map(favoritesBo -> {
                    FavoritesResVo favoritesVo = new FavoritesResVo();
                    favoritesVo.setItemId(favoritesBo.getItemId());
                    favoritesVo.setItem(favoritesBo.getItem());
                    return favoritesVo;
                }).collect(Collectors.toList());
    }
}
