package it.crazyones.easyexplore.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class IdentifiableEntity extends BaseEntity{
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)", name = "id", updatable = false, nullable = false)
    protected String _id;

    @Override
    public int hashCode() {
        return _id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof IdentifiableEntity)) {
            return false;
        }
        IdentifiableEntity other = (IdentifiableEntity) obj;
        return get_id().equals(other.get_id());
    }
}
