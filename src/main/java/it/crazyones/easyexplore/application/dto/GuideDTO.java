package it.crazyones.easyexplore.application.dto;

import it.crazyones.easyexplore.application.mapper.GuideMapper;
import it.crazyones.easyexplore.domain.model.Guide;
import lombok.*;

import java.time.Instant;
import java.util.List;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(callSuper=false)
public class GuideDTO extends ResourceDTO<Guide> {
    @NonNull
    private String _id;

    @NonNull
    protected String firstName;

    @NonNull
    protected String lastName;

    protected String phone;
    protected String email;
    protected String password;
    protected String profileImage;
    protected AddressDTO address;

    @NonNull
    private String about;
    private float rating;

    @NonNull
    private MoneyDTO rate;

    private List<String> services;
    private List<LanguageDTO> languages;
    private List<AttractionDTO> attractions;
    private List<MemoryDTO> memories;

    protected Instant createdDate;
    protected Instant lastModifiedDate;

    @Override
    public Guide asEntity() {
        return GuideMapper.INSTANCE.toEntity(this);
    }
}
