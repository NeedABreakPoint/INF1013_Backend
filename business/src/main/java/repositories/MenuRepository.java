package repositories;

import model.MenuInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuInfo, Long> {
    // 如果需要，可以在这里添加自定义查询方法
}
