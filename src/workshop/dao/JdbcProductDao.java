package workshop.dao;

import workshop.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {

    private final String url;
    private final String user;
    private final String password;

    private final String GET_ALL_PRODUCTS_QUERY =
            "SELECT * FROM products";

    public JdbcProductDao(String url, String name, String password) {
        this.url = url;
        this.user = name;
        this.password = password;
    }

    private Connection createConnection() throws SQLException {
           return DriverManager.getConnection(url,user, password);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try(Connection connection = createConnection();
            PreparedStatement statement =
                    connection.prepareStatement(GET_ALL_PRODUCTS_QUERY);
            ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                products.add(mapToProduct(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    private Product mapToProduct(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        int id = resultSet.getInt("id");
        double price = resultSet.getDouble("price");
        return new Product(id, name, description, price);
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void removeProduct(Product product) {

    }

    @Override
    public Product findProductById(int id) {
        return null;
    }
}
