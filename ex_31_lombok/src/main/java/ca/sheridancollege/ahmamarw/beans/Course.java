package ca.sheridancollege.ahmamarw.beans;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Course {
    @NonNull
    private Long id;
    private String prefix;
    private String code;
    private String name;
}
