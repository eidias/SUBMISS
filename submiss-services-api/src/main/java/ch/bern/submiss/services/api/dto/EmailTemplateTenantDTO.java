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

package ch.bern.submiss.services.api.dto;

import ch.bern.submiss.services.api.constants.EmailTemplate;
import ch.bern.submiss.services.api.util.View;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;

/**
 * The Class EmailTemplateTenantDTO.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EmailTemplateTenantDTO extends AbstractDTO {

  /** The tenant. */
  @JsonView(View.Internal.class)
  private TenantDTO tenant;

  /** The subject. */
  @JsonView(View.Public.class)
  private String subject;

  /** The content. */
  @JsonView(View.Public.class)
  private String content;

  /** The email template. */
  @JsonView(View.Internal.class)
  private EmailTemplateDTO emailTemplate;

  /** The attributes. */
  @JsonView(View.Public.class)
  private List<EmailAttributesDTO> attributes;

  /** The description. */
  @JsonView(View.Public.class)
  private String description;

  /** The is active. */
  @JsonView(View.Internal.class)
  private Boolean isActive;

  /** The available part. */
  @JsonView(View.Public.class)
  private EmailTemplate.AVAILABLE_PART availablePart;

  /**
   * Gets the tenant.
   *
   * @return the tenant
   */
  public TenantDTO getTenant() {
    return tenant;
  }

  /**
   * Sets the tenant.
   *
   * @param tenant the new tenant
   */
  public void setTenant(TenantDTO tenant) {
    this.tenant = tenant;
  }

  /**
   * Gets the subject.
   *
   * @return the subject
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Sets the subject.
   *
   * @param subject the new subject
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * Gets the content.
   *
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * Sets the content.
   *
   * @param content the new content
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * Gets the email template.
   *
   * @return the email template
   */
  public EmailTemplateDTO getEmailTemplate() {
    return emailTemplate;
  }

  /**
   * Sets the email template.
   *
   * @param emailTemplate the new email template
   */
  public void setEmailTemplate(EmailTemplateDTO emailTemplate) {
    this.emailTemplate = emailTemplate;
  }

  /**
   * Gets the attributes.
   *
   * @return the attributes
   */
  public List<EmailAttributesDTO> getAttributes() {
    return attributes;
  }

  /**
   * Sets the attributes.
   *
   * @param attributes the new attributes
   */
  public void setAttributes(List<EmailAttributesDTO> attributes) {
    this.attributes = attributes;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets the checks if is active.
   *
   * @return the checks if is active
   */
  public Boolean getIsActive() {
    return isActive;
  }

  /**
   * Sets the checks if is active.
   *
   * @param isActive the new checks if is active
   */
  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  /**
   * Gets the available part.
   *
   * @return the available part
   */
  public EmailTemplate.AVAILABLE_PART getAvailablePart() {
    return availablePart;
  }

  /**
   * Sets the available part.
   *
   * @param availablePart the new available part
   */
  public void setAvailablePart(EmailTemplate.AVAILABLE_PART availablePart) {
    this.availablePart = availablePart;
  }
}
