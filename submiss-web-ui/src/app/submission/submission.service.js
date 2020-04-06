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
 * @name submission.service.js
 * @description SubmissionService service
 */
(function () {
  "use strict";

  angular // eslint-disable-line no-undef
    .module("submiss.submission")
    .factory("SubmissionService", SubmissionService);

  /** @ngInject */
  function SubmissionService($http, AppConstants) {
    /***********************************************************************
     * Local variables.
     **********************************************************************/

    /***********************************************************************
     * Local functions.
     **********************************************************************/

    /***********************************************************************
     * Exported functions and variables.
     **********************************************************************/

    return {
      createSubmission: function (submission) {
        return $http.post(AppConstants.URLS.RESOURCE_PROVIDER + '/submission',
          submission);
      },
      readProjectSubmissions: function (projectId) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/project/' +
          projectId);
      },
      deleteSubmission: function (id) {
        return $http.delete(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/' + id);
      },
      readSubmission: function (id) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/' + id);
      },
      updateSubmission: function (submission) {
        return $http.put(AppConstants.URLS.RESOURCE_PROVIDER + '/submission',
          submission);
      },
      setCompanyToSubmission: function (submissionId, companyId) {
        return $http.put(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/' + submissionId +
          '/?' + companyId);
      },
      readCompaniesBySubmission: function (id) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/companies/' + id);
      },
      getCurrentStatusOfSubmission: function (submissionId) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/status/' +
          submissionId);
      },
      hasSubmissionStatus: function (submissionId, statusId) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/status/' +
          submissionId + '/' + statusId);
      },
      checkSubmittentList: function (id) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/status/submittent/' +
          id);
      },
      checkedSubmittentList: function (id) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/status/checked/' +
          id);
      },
      readSubmittentsBySubmission: function (id) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/' + id +
          '/submittents');
      },
      checkReasonGiven: function (reopen, statusToReopen) {
        return $http.post(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/reopenStatus/' +
          statusToReopen, reopen);
      },
      hasOfferOpeningBeenClosedBefore: function (submissionId) {
        return $http.get(AppConstants.URLS.RESOURCE_PROVIDER +
          '/submission/hasOfferOpeningBeenClosedBefore/' + submissionId);
      },
      getProjectTemplates: function (submissionId) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/getTemplates/' +
          submissionId);
      },
      isOfferAboveThreshold: function (submissionId) {
        return $http.get(AppConstants.URLS.RESOURCE_PROVIDER +
          '/submission/isOfferAboveThreshold/' + submissionId);
      },
      getCurrentStatusDataOfSubmission: function (submissionId) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/status/data/' +
          submissionId);
      },
      getAwardNoticesCreatedDateForClose: function (submissionId, statusId) {
        return $http.get(AppConstants.URLS.RESOURCE_PROVIDER +
          '/submission/awardNoticesCreatedDate/' + submissionId);
      },
      closeSubmission: function (submissionId) {
        return $http.post(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/close/' +
          submissionId);
      },
      reopenSubmission: function (submissionId, reopen) {
        return $http.post(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/reopenSubmission/' +
          submissionId, reopen);
      },
      getDateAndPreviousReopenStatus: function (submissionId) {
        return $http.get(AppConstants.URLS.RESOURCE_PROVIDER +
          '/submission/status/getDateAndPreviousReopen/' + submissionId);
      },
      getTemplatesByDepartment: function (submissionId) {
        return $http.get(AppConstants.URLS.RESOURCE_PROVIDER +
          '/submission/getTemplates/department/' + submissionId);
      },
      hasSuitabilityAuditCompletedSBeenSetBefore: function (submissionId) {
        return $http.get(AppConstants.URLS.RESOURCE_PROVIDER +
          '/submission/hasSuitabilityAuditCompletedSBeenSetBefore/' +
          submissionId);
      },
      getAwardInfo: function (submissionId) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/award/info/' +
          submissionId);
      },
      saveAwardInfo: function (awardInfo) {
        return $http.put(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/saveAwardInfo',
          awardInfo);
      },
      loadSignatures: function (submissionId) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/signatures/' +
          submissionId);
      },
      getApplicantsBySubmission: function (submissionId) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/applicants/' +
          submissionId);
      },
      submissionCancelNavigation: function (submissionId) {
        return $http.get(AppConstants.URLS.RESOURCE_PROVIDER +
          '/submission/submissionCancelNavigation/' + submissionId);
      },
      getAwardInfoFirstLevel: function (submissionId) {
        return $http.get(AppConstants.URLS.RESOURCE_PROVIDER +
          '/submission/awardInfoFirstLevel/' + submissionId);
      },
      saveAwardInfoFirstLevel: function (awardInfo) {
        return $http.put(AppConstants.URLS.RESOURCE_PROVIDER +
          '/submission/saveAwardInfoFirstLevel', awardInfo);
      },
      loadEmailTemplates: function (submissionId) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/email/retrieve/' +
          submissionId);
      },
      sendMail: function (submissionId, emailTemplate) {
        return $http.post(
          AppConstants.URLS.RESOURCE_PROVIDER + '/email/' + submissionId,
          emailTemplate);
      },
      moveProjectData: function (submissionId, projectId) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/moveProjectData/' +
          submissionId + '/' + projectId);
      },
      lockSubmission: function (submissionId, type) {
        return $http.put(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/lock/' +
          submissionId + '/' + type);
      },
      unlockSubmission: function (submissionId, type) {
        return $http.put(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/unlock/' +
          submissionId + '/' + type);
      },
      readSubmittentsCount: function (submissionId) {
        return $http.get(
          AppConstants.URLS.RESOURCE_PROVIDER + '/submission/submittents/' +
          submissionId);
      }
    };
  }
})();
