package controllers;

import dto.MenuDto;
import model.MenuInfo;
import services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseEntity<List<MenuDto>> getAllMenus() {
        List<MenuDto> dtos = menuService.findAll().stream()
                .map(MenuDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<MenuDto> createMenu(@RequestBody MenuDto menuDTO) {
        MenuInfo menu = menuService.save(menuDTO.toEntity());
        return ResponseEntity.ok(new MenuDto(menu));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.delete(id);
        return ResponseEntity.ok().build();
    }
}
