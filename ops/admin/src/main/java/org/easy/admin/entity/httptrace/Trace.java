package org.easy.admin.entity.httptrace;

import lombok.Data;

@Data
public class Trace {
    Request request;
    Long timeTaken;
}
