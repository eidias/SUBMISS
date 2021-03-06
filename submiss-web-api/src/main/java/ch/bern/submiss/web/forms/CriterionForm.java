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

package ch.bern.submiss.web.forms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CriterionForm extends AbstractForm {

  private String submission;
  private Long submissionVersion;
  private String criterionText;
  private Double weighting;
  private String criterionType;
  private List<SubcriterionForm> subcriterion;
  private Boolean show;
  private Timestamp pageRequestedOn;

  public String getSubmission() {
    return submission;
  }

  public void setSubmission(String submission) {
    this.submission = submission;
  }

  public String getCriterionText() {
    return criterionText;
  }

  public void setCriterionText(String criterionText) {
    this.criterionText = criterionText;
  }

  public Double getWeighting() {
    return weighting;
  }

  public void setWeighting(Double weighting) {
    this.weighting = weighting;
  }

  public String getCriterionType() {
    return criterionType;
  }

  public void setCriterionType(String criterionType) {
    this.criterionType = criterionType;
  }

  public List<SubcriterionForm> getSubcriterion() {
    return subcriterion;
  }

  public void setSubcriterion(List<SubcriterionForm> subcriterion) {
    this.subcriterion = subcriterion;
  }

  public Boolean getShow() {
    return show;
  }

  public void setShow(Boolean show) {
    this.show = show;
  }

  public Timestamp getPageRequestedOn() {
    return pageRequestedOn;
  }

  public void setPageRequestedOn(Timestamp pageRequestedOn) {
    this.pageRequestedOn = pageRequestedOn;
  }

  public Long getSubmissionVersion() {
    return submissionVersion;
  }

  public void setSubmissionVersion(Long submissionVersion) {
    this.submissionVersion = submissionVersion;
  }
}
