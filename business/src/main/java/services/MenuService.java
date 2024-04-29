package services;

import model.MenuInfo;
import repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<MenuInfo> findAll() {
        return menuRepository.findAll();
    }

    public MenuInfo findById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    public MenuInfo save(MenuInfo menuInfo) {
        return menuRepository.save(menuInfo);
    }

    public void delete(Long id) {
        menuRepository.deleteById(id);
    }
}
