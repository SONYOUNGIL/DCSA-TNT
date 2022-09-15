package org.dcsa.tnt.transferobjects;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import lombok.Data;
import org.dcsa.tnt.transferobjects.enums.EventClassifierCode;
import java.time.OffsetDateTime;
import java.util.UUID;

@JsonTypeInfo(use = Id.NAME, property = "eventType")
@JsonSubTypes({
  @Type(value = AggregatedEquipmentEventTO.class, name = "EQUIPMENT"),
  @Type(value = AggregatedTransportEventTO.class, name = "TRANSPORT"),
  @Type(value = AggregatedShipmentEventTO.class, name = "SHIPMENT"),
  @Type(value = AggregatedOperationsEventTO.class, name = "OPERATIONS")
})
@Data
public abstract class AggregatedEventTO {
  private UUID eventID;

  private OffsetDateTime eventDateTime;

  private OffsetDateTime eventCreatedDateTime;

  private EventClassifierCode eventClassifierCode;
}
