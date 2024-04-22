package DTO;

import model.MenuInfo;

public class MenuDto {
    private Long id;
    private Long restaurantId;
    private String name;
    private String description;
    private Double price;
    private String category;
    private String imageUrl;

    // Constructor that initializes the DTO from a MenuInfo entity
    public MenuDto(MenuInfo menu) {
        if (menu != null) {
            this.id = menu.getId();
            this.restaurantId = menu.getRestaurantId();
            this.name = menu.getName();
            this.description = menu.getDescription();
            this.price = menu.getPrice();
            this.category = menu.getCategory();
            this.imageUrl = menu.getImageUrl();
        }
    }

    // Method to convert this DTO to an entity
    public MenuInfo toEntity() {
        MenuInfo menu = new MenuInfo();
        menu.setId(this.id);
        menu.setRestaurantId(this.restaurantId);
        menu.setName(this.name);
        menu.setDescription(this.description);
        menu.setPrice(this.price);
        menu.setCategory(this.category);
        menu.setImageUrl(this.imageUrl);
        return menu;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
