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

package ch.bern.submiss.web.resources;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ops4j.pax.cdi.api.OsgiService;

import ch.bern.submiss.services.api.administration.SDProcessTypeService;
import ch.bern.submiss.services.api.dto.MasterListValueHistoryDTO;

@Path("/sd/processtype/{projectId}")
@Singleton
public class SDProcessTypeResource {

  @OsgiService
  @Inject
  private SDProcessTypeService sDProcessTypeService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<MasterListValueHistoryDTO> readAll(@PathParam("projectId") String projectId) {
    return sDProcessTypeService.readAll(projectId);
  }
}
