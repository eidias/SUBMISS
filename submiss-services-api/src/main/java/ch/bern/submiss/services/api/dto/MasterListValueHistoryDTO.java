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

import ch.bern.submiss.services.api.util.View;
import com.fasterxml.jackson.annotation.JsonView;
import java.sql.Timestamp;
import java.util.Date;

/**
 * The Class MasterListValueHistoryDTO.
 */
public class MasterListValueHistoryDTO extends AbstractDTO {

  /** The value 1. */
  @JsonView(View.Public.class)
  private String value1;

  /** The active. */
  @JsonView(View.Internal.class)
  private boolean active;

  /** The tenant. */
  @JsonView(View.Internal.class)
  private TenantDTO tenant;

  /** The modified on. */
  @JsonView(View.Internal.class)
  private Date modifiedOn;

  /** The internal version. */
  @JsonView(View.Internal.class)
  private Integer internalVersion;

  /** The value 2. */
  @JsonView(View.Public.class)
  private String value2;

  /** The from date. */
  @JsonView(View.Internal.class)
  private Timestamp fromDate;

  /** The to date. */
  @JsonView(View.Internal.class)
  private Timestamp toDate;

  /** The master list value id. */
  @JsonView(View.Internal.class)
  private MasterListValueDTO masterListValueId;

  /** The short code. */
  @JsonView(View.Internal.class)
  private String shortCode;

  /** The tenant logo */
  @JsonView(View.Internal.class)
  private byte[] tenantLogo;

  /**
   * Gets the value 1.
   *
   * @return the value 1
   */
  public String getValue1() {
    return value1;
  }

  /**
   * Sets the value 1.
   *
   * @param value1 the new value 1
   */
  public void setValue1(String value1) {
    this.value1 = value1;
  }

  /**
   * Checks if is active.
   *
   * @return true, if is active
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets the active.
   *
   * @param active the new active
   */
  public void setActive(boolean active) {
    this.active = active;
  }

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
   * Gets the modified on.
   *
   * @return the modified on
   */
  public Date getModifiedOn() {
    return modifiedOn;
  }

  /**
   * Sets the modified on.
   *
   * @param modifiedOn the new modified on
   */
  public void setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  /**
   * Gets the internal version.
   *
   * @return the internal version
   */
  public Integer getInternalVersion() {
    return internalVersion;
  }

  /**
   * Sets the internal version.
   *
   * @param internalVersion the new internal version
   */
  public void setInternalVersion(Integer internalVersion) {
    this.internalVersion = internalVersion;
  }

  /**
   * Gets the value 2.
   *
   * @return the value 2
   */
  public String getValue2() {
    return value2;
  }

  /**
   * Sets the value 2.
   *
   * @param value2 the new value 2
   */
  public void setValue2(String value2) {
    this.value2 = value2;
  }

  /**
   * Gets the from date.
   *
   * @return the from date
   */
  public Timestamp getFromDate() {
    return fromDate;
  }

  /**
   * Sets the from date.
   *
   * @param fromDate the new from date
   */
  public void setFromDate(Timestamp fromDate) {
    this.fromDate = fromDate;
  }

  /**
   * Gets the to date.
   *
   * @return the to date
   */
  public Timestamp getToDate() {
    return toDate;
  }

  /**
   * Sets the to date.
   *
   * @param toDate the new to date
   */
  public void setToDate(Timestamp toDate) {
    this.toDate = toDate;
  }

  /**
   * Gets the master list value id.
   *
   * @return the master list value id
   */
  public MasterListValueDTO getMasterListValueId() {
    return masterListValueId;
  }

  /**
   * Sets the master list value id.
   *
   * @param masterListValueId the new master list value id
   */
  public void setMasterListValueId(MasterListValueDTO masterListValueId) {
    this.masterListValueId = masterListValueId;
  }

  /**
   * Gets the short code.
   *
   * @return the short code
   */
  public String getShortCode() {
    return shortCode;
  }

  /**
   * Sets the short code.
   *
   * @param shortCode the new short code
   */
  public void setShortCode(String shortCode) {
    this.shortCode = shortCode;
  }

  /**
   * Gets the tenant logo.
   *
   * @return the tenant logo
   */
  public byte[] getTenantLogo() {
    return tenantLogo;
  }

  /**
   * Sets the tenant logo.
   *
   * @param tenantLogo the new tenant logo
   */
  public void setTenantLogo(byte[] tenantLogo) {
    this.tenantLogo = tenantLogo;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "MasterListValueHistoryDTO [value1=" + value1 + ", active=" + active
        + ", modifiedOn=" + modifiedOn + ", internalVersion=" + internalVersion + ", value2="
        + value2 + ", fromDate=" + fromDate + ", toDate=" + toDate + ", shortCode=" + shortCode
        + "]";
  }


}
