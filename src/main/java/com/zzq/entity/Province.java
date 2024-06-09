package com.zzq.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author zzq
 * @since 2024-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Province {
    private Long province;
    private String addr;
}
