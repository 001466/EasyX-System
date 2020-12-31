package org.easy.admin.entity;

import lombok.Data;
import org.easy.admin.entity.httptrace.Trace;

import java.util.List;

@Data
public class HttpTrace {
    List<Trace> traces;
}
