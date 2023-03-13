package com.sample.carmarket;

import com.sample.carmarket.app.CarService;
import com.sample.carmarket.entity.Car;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.ActionType;
import io.jmix.ui.action.ItemTrackingAction;
import io.jmix.ui.component.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@ActionType("markAsSold")
public class MarkAsSold extends ItemTrackingAction {
    @Autowired
    private CarService carService;
    @Autowired
    private Notifications notifications;
    public MarkAsSold(String id) {
        super(id);
    }

    @Override
    public void actionPerform(Component component) {
        Car singleSelected = (Car) target.getSingleSelected();
        UUID id = singleSelected.getId();
        String str = carService.markAsSold(id);
        notifications.create()
                .withCaption(str)
                .show();
    }
}
