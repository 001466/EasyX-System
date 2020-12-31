package org.easy.admin.entity.metrics;

import lombok.Data;

import java.util.List;

@Data
public class AvailableTag {
    String tag;
    List<String> values;
}
