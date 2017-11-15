<div class="panel panel-primary">
    <!-- Default panel contents -->
    <div class="panel-heading">Class Registration</div>
    <div class="panel-body">
        <div id='new-registration-direct-search-template'>
            <jsp:include page="/new-registration-direct-search.jsp" />
        </div>
        <div id="new-registration-questionnaire-template" style="display:none">
            <jsp:include page="/new-registration-questionnaire.jsp" />
        </div>
        <div id="class-detail-template" style="display:none">
            <jsp:include page="/class-detail.jsp" />
        </div>
    </div>
</div>

<div id="registration-suggestion-template" style="display:none">
    <jsp:include page="/registration-suggestion.jsp" />
</div>