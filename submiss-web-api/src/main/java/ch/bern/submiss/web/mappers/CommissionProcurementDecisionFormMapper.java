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

package ch.bern.submiss.web.mappers;

import ch.bern.submiss.services.api.dto.CommissionProcurementDecisionDTO;
import ch.bern.submiss.web.forms.CommissionProcurementDecisionForm;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CommissionProcurementDecisionFormMapper {
  public static final CommissionProcurementDecisionFormMapper INSTANCE =
    Mappers.getMapper(CommissionProcurementDecisionFormMapper.class);

  public abstract CommissionProcurementDecisionDTO toCommissionProcurementDecisionDTO(
    CommissionProcurementDecisionForm form);

  public abstract List<CommissionProcurementDecisionDTO> toCommissionProcurementDecisionDTO(
    List<CommissionProcurementDecisionForm> formList);

  public abstract CommissionProcurementDecisionForm toCommissionProcurementDecisionForm(
    CommissionProcurementDecisionDTO dto);

  public abstract List<CommissionProcurementDecisionForm> toCommissionProcurementDecisionForm(
    List<CommissionProcurementDecisionDTO> dtoList);
}
