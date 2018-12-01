package org.app;

import org.app.entity.Shop;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="c", types= {Shop.class})
public interface ShopProjection {
	
}
