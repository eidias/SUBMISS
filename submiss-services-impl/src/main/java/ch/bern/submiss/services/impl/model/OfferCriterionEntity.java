/*
 *  Submiss, eProcurement system for managing tenders
 *  Copyright (C) 2019 Stadt Bern
 *  Licensed under the EUPL, Version 1.2 or - as soon as they will be approved by the European Commission - subsequent versions of the EUPL (the "Licence");
 *  You may not use this work except in compliance with the Licence.
 *  You may obtain a copy of the Licence at:
 *  https://joinup.ec.europa.eu/collection/eupl
 *  Unless required by applicable law or agreed to in writing, software distributed under the Licence is
 *  distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *  express or implied. See the Licence for the specific language governing permissions and limitations
 *  under the Licence.
 */

package ch.bern.submiss.services.impl.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * The Class OfferCriterionEntity.
 */
@Entity
@Table(name = "SUB_OFFER_CRITERION")
public class OfferCriterionEntity {

  /** The id. */
  @Id
  @GeneratedValue(generator = "uuid1")
  @GenericGenerator(name = "uuid1", strategy = "uuid2")
  private String id;

  /** The offer. */
  @ManyToOne
  @JoinColumn(name = "FK_OFFER")
  private OfferEntity offer;

  /** The criterion. */
  @ManyToOne
  @JoinColumn(name = "FK_CRITERION")
  private CriterionEntity criterion;

  /** The grade. */
  @Column(name = "GRADE")
  private BigDecimal grade;

  /** The score. */
  @Column(name = "SCORE")
  private BigDecimal score;

  /** The is fulfilled. */
  @Column(name = "IS_FULFILLED")
  private Boolean isFulfilled;

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets the offer.
   *
   * @return the offer
   */
  public OfferEntity getOffer() {
    return offer;
  }

  /**
   * Sets the offer.
   *
   * @param offer the new offer
   */
  public void setOffer(OfferEntity offer) {
    this.offer = offer;
  }

  /**
   * Gets the criterion.
   *
   * @return the criterion
   */
  public CriterionEntity getCriterion() {
    return criterion;
  }

  /**
   * Sets the criterion.
   *
   * @param criterion the new criterion
   */
  public void setCriterion(CriterionEntity criterion) {
    this.criterion = criterion;
  }

  /**
   * Gets the grade.
   *
   * @return the grade
   */
  public BigDecimal getGrade() {
    return grade;
  }

  /**
   * Sets the grade.
   *
   * @param grade the new grade
   */
  public void setGrade(BigDecimal grade) {
    this.grade = grade;
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public BigDecimal getScore() {
    return score;
  }

  /**
   * Sets the score.
   *
   * @param score the new score
   */
  public void setScore(BigDecimal score) {
    this.score = score;
  }

  /**
   * Gets the checks if is fulfilled.
   *
   * @return the checks if is fulfilled
   */
  public Boolean getIsFulfilled() {
    return isFulfilled;
  }

  /**
   * Sets the checks if is fulfilled.
   *
   * @param isFulfilled the new checks if is fulfilled
   */
  public void setIsFulfilled(Boolean isFulfilled) {
    this.isFulfilled = isFulfilled;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "OfferCriterionEntity [id=" + id + ",  grade=" + grade + ", score=" + score
        + ", isFulfilled=" + isFulfilled + "]";
  }

}
