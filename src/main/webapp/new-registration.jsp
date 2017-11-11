<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">Class Registration</div>
    <div class="panel-body">

        <div id = 'new-registration-direct-search-template'>
            <jsp:include page="/new-registration-direct-search.jsp" />
        </div>        

        <p>or do you want to use our smart registration helper?</p>
        <button id="fetch-student">I need a helper!</button>

        <div id = 'new-registration-questionnaire-template'>
            <jsp:include page="/new-registration-questionnaire.jsp" />
        </div>

        
    </div>
</div>