package it.crazyones.easyexplore.application.dto;

import it.crazyones.easyexplore.application.mapper.AttractionMapper;
import it.crazyones.easyexplore.domain.model.Attraction;
import it.crazyones.easyexplore.domain.model.GeographicLocation;
import lombok.*;

import java.util.List;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(callSuper=false)
public class AttractionDTO extends ResourceDTO<Attraction> {
    @NonNull
    private String _id;

    @NonNull
    private String name;
    private String about;
    private GeographicLocation location;
    private List<String> images;

    @Override
    public Attraction asEntity() {
        return AttractionMapper.INSTANCE.toEntity(this);
    }
}
