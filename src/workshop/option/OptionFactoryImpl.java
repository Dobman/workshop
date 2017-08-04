package workshop.option;

import workshop.action.product.AddProductAction;
import workshop.action.product.DeleteProductAction;
import workshop.action.product.PrintAllProductAction;
import workshop.action.product.UpdateProductAction;
import workshop.dao.ProductDao;

public class OptionFactoryImpl implements OptionFactory {

    private final ProductDao productDao;

    public OptionFactoryImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Option createProductOption() {
        Option option = new Option(1, "Product options");
        option.actions.add(new AddProductAction(productDao));
        option.actions.add(new PrintAllProductAction(productDao));
        option.actions.add(new DeleteProductAction(productDao));
        option.actions.add(new UpdateProductAction(productDao));
        return option;
    }

    @Override
    public Option createOrderOption() {
        return null;
    }
}
