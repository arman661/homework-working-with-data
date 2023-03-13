package com.sample.carmarket.screen.manufacturer;

import com.sample.carmarket.app.CarService;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.*;
import com.sample.carmarket.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;

@UiController("Manufacturer.browse")
@UiDescriptor("manufacturer-browse.xml")
@LookupComponent("table")
public class ManufacturerBrowse extends MasterDetailScreen<Manufacturer> {
    @Autowired
    private CarService carService;
    @Autowired
    private Notifications notifications;

    @Subscribe("CalculateCars")
    public void onCalculateCarsClick(Button.ClickEvent event) {
        Integer electricCarsCount = carService.calculateGasolineCars("E");
        Integer gasolineCarsCount = carService.calculateGasolineCars("G");
        notifications.create()
                .withCaption(String.format("Electric cars: %s, gasoline cars: %s", electricCarsCount, gasolineCarsCount))
                .show();
    }
}