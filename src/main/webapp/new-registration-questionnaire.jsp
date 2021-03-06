<div>
    <div id="question">
        <div class="form-group">
            <label class="col-md-12 h4" for="class-level">What Class Level are you looking for?</label>
            <div class="col-md-12">
                <label>
                    <input type="checkbox" id="class-level" value="Graduate" checked data-toggle="toggle" data-onstyle="primary"
                        data-offstyle="warning" data-size="normal" data-width="180" data-on="Graduate" data-off="Undergraduate"/>
                </label>
                <div id="class-level-mismatch" class="alert alert-warning" role="alert" style="display:none">
                    <p><strong>Your class level does not match with the selected preference.</strong></p>
                    <p>You can only view classes without being able to register</p>
                </div>
                
            </div>


            <label class="col-md-12 h4">Which Class Major are you looking for?</label>
          
            <label class="col-md-12">
                <input type="checkbox" id="check-all-major" value="software-engineer"
                    data-toggle="toggle" data-size="small" data-onstyle="success"> Check all Majors
            </label>               
            <label class="col-md-12">
                <input type="checkbox" id="software-engineer" value="software-engineer" class="major"
                    data-toggle="toggle" data-size="small" data-onstyle="success"> Software Engineering
            </label>
            <label class="col-md-12">
                <input type="checkbox" id="computer-science" value="computer-science" class="major"
                    data-toggle="toggle" data-size="small" data-onstyle="success"> Computer Science
            </label>          
            <button class="btn btn-primary" id="calculate-suggestion" style="display: none">Process Suggestion</button>
        </div>
    </div>

    <div id="class-search-result-template" style="display:none">
        <jsp:include page="/class-search-result.jsp"/>
    </div>



</div>