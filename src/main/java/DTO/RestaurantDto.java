package dto;



import model.RestaurantInfo;

public class RestaurantDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String phone;
    private String category;

    public RestaurantDto() {
    }

    public RestaurantDto(RestaurantInfo restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.description = restaurant.getDescription();
        this.address = restaurant.getAddress();
        this.phone = restaurant.getPhone();
        this.category = restaurant.getCategory();
    }

    public RestaurantInfo toEntity() {
        RestaurantInfo restaurant = new RestaurantInfo();
        restaurant.setId(this.id);
        restaurant.setName(this.name);
        restaurant.setDescription(this.description);
        restaurant.setAddress(this.address);
        restaurant.setPhone(this.phone);
        restaurant.setCategory(this.category);
        return restaurant;
    }

    // Getters and Setters
}
