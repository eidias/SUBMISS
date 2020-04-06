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

/**
 * @ngdoc service
 * @name submissionCancel.service.js
 * @description SubmissionCancel service
 */
(function () {
  "use strict";

  angular // eslint-disable-line no-undef
    .module("submiss.document")
    .factory("SubmissionCancelService", SubmissionCancelService);

  /** @ngInject */
  function SubmissionCancelService($http, AppConstants) {
    return {
      getSubmissionCancelBySubmissionId: function (submissionId) {
        return $http.get(AppConstants.URLS.RESOURCE_PROVIDER + '/submissionCancel/' + submissionId);
      },
      setSubmissionCancel: function (submissionCancel) {
        return $http.post(AppConstants.URLS.RESOURCE_PROVIDER + '/submissionCancel', submissionCancel);
      },
      cancelSubmission: function (submissionId) {
        return $http.post(AppConstants.URLS.RESOURCE_PROVIDER + '/submissionCancel/cancel/' + submissionId);
      },
      getAvailableDateBySubmissionId: function (submissionId) {
        return $http.get(AppConstants.URLS.RESOURCE_PROVIDER + '/submissionCancel/availableDate/' + submissionId);
      },
      cancellationDocumentCreated: function (submissionId) {
        return $http.get(AppConstants.URLS.RESOURCE_PROVIDER + '/submissionCancel/cancellationDocumentCreated/' + submissionId);
      }
    };
  }
})();