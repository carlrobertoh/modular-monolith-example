package ee.carlr.basket.internal;

import ee.carlr.basket.Basket;
import ee.carlr.product.ProductComponent;
import ee.carlr.product.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static ee.carlr.basket.BasketState.CONFIRMED;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BasketComponentImplTest {
  @Captor
  private ArgumentCaptor<Basket> basketCaptor;

  @Mock
  private BasketRepository basketRepository;

  @Mock
  private ProductComponent productComponent;

  @InjectMocks
  private BasketComponentImpl basketComponentImpl;

  @Test
  public void shouldConfirmBasket() {
    Basket basket = new Basket(null);
    basketComponentImpl.confirmBasket(basket);

    assertThat(basket.getState(), is(CONFIRMED));
    verify(basketRepository).update(basket);
  }

  @Test(expected = RuntimeException.class)
  public void shouldThrowExceptionWhenConfirmingAlreadyConfirmedBasket() {
    Basket basket = new Basket(null);
    basket.markConfirmed();

    basketComponentImpl.confirmBasket(basket);
  }

  @Test
  public void shouldAddProductToBasket() {
    long basketId = 1L;
    long productId = 2L;
    Product product = new Product(productId, "Book", 9.99);
    doReturn(new Basket(null)).when(basketRepository).getBasket(basketId);
    doReturn(product).when(productComponent).getProduct(productId);

    basketComponentImpl.addProduct(basketId, productId);

    verify(basketRepository).update(basketCaptor.capture());
    Basket actual = basketCaptor.getValue();
    assertThat(actual.getProducts().size(), is(1));
    assertThat(actual.getProducts().contains(product), is(true));
  }
}
