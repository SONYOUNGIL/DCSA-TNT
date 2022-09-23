package org.dcsa.tnt.controller;

import lombok.RequiredArgsConstructor;
import org.dcsa.tnt.service.EventService;
import org.dcsa.tnt.transferobjects.EquipmentEventTO;
import org.dcsa.tnt.transferobjects.EventTO;
import org.dcsa.tnt.transferobjects.ShipmentEventTO;
import org.dcsa.tnt.transferobjects.TransportEventTO;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {
  private final EventService eventService;

  @GetMapping(path = "/events")
  @ResponseStatus(HttpStatus.OK)
  public List<EventTO> findAllEvents() {
    return eventService.findAll();
  }

  @Profile("test")
  @GetMapping(path = "/uncached-shipment-events")
  @ResponseStatus(HttpStatus.OK)
  public List<ShipmentEventTO> findAllShipmentEvents() {
    return eventService.findAllShipmentEvents();
  }

  @Profile("test")
  @GetMapping(path = "/uncached-transport-events")
  @ResponseStatus(HttpStatus.OK)
  public List<TransportEventTO> findAllTransportEvents() {
    return eventService.findAllTransportEvents();
  }

  @Profile("test")
  @GetMapping(path = "/uncached-equipment-events")
  @ResponseStatus(HttpStatus.OK)
  public List<EquipmentEventTO> findAllEquipmentEvents() {
    return eventService.findAllEquipmentEvents();
  }
}
