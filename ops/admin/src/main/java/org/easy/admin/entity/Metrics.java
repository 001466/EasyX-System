package org.easy.admin.entity;

import lombok.Data;
import org.easy.admin.entity.metrics.AvailableTag;
import org.easy.admin.entity.metrics.Measurement;

import java.util.List;

@Data
public class Metrics {
    List<Measurement> measurements;
    List<AvailableTag> availableTags;
}
