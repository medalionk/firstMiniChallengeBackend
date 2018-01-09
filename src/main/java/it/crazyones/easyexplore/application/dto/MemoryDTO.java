package it.crazyones.easyexplore.application.dto;

import it.crazyones.easyexplore.application.mapper.MemoryMapper;
import it.crazyones.easyexplore.domain.model.Memory;
import lombok.*;

import java.util.List;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(callSuper=false)
public class MemoryDTO extends ResourceDTO<Memory> {
    @NonNull
    private String _id;

    @NonNull
    private String name;
    private List<String> images;

    @Override
    public Memory asEntity() {
        return MemoryMapper.INSTANCE.toEntity(this);
    }
}
