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

import ch.bern.submiss.services.api.dto.LegalHearingTerminateDTO;
import ch.bern.submiss.web.forms.LegalHearingTerminateForm;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {SubmissionMapper.class, MasterListValueMapper.class})
public abstract class LegalHearingTerminateFormMapper {

  public static final LegalHearingTerminateFormMapper INSTANCE =
    Mappers.getMapper(LegalHearingTerminateFormMapper.class);

  public abstract LegalHearingTerminateDTO toLegalHearingTerminateDTO(
    LegalHearingTerminateForm form);

  public abstract List<LegalHearingTerminateDTO> toLegalHearingTerminateDTO(
    List<LegalHearingTerminateForm> formList);

  public abstract LegalHearingTerminateForm toLegalHearingTerminateForm(
    LegalHearingTerminateDTO dto);

  public abstract List<LegalHearingTerminateForm> toLegalHearingTerminateForm(
    List<LegalHearingTerminateDTO> dtoList);
}
