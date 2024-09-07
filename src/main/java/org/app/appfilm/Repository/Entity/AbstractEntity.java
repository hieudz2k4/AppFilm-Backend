package org.app.appfilm.Repository.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity<T> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private T id;

  // auditing
  @Column(name = "created_at")
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @Column(name = "created_by")
  @CreatedBy
  private T createdBy;

  @Column(name = "updated_at")
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  @Column(name = "updated_by")
  @LastModifiedBy
  private T updatedBy;
}
