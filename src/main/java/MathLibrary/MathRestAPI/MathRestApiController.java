package MathLibrary.MathRestAPI;

import Math_Evaluation_Library.Engine.Engine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antonio on 2018-02-19.
 */
@RestController
public class MathRestApiController {

    @CrossOrigin
    @GetMapping("/")
    public String defaultPage() {
        return "Hello! This is the Math Rest API by Antonio Kim. Visit https://github.com/antoniok9130/Math-Rest-API to see how to use this API.";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/error", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
    public ResponseEntity<String> error(){
        return new ResponseEntity<String>("Math Rest API by Antonio Kim is not available right now.", HttpStatus.BAD_REQUEST);
    }

    public static class Input {
        private String value = null;

        public Input(){}
        public Input(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setInput(String value) {
            if (this.value == null) this.value = value;
        }
//        public void setInput(String input) {
//            if (this.value == null) this.value = input;
//        }
    }
    public static class Output {
        private Object value = null;

        public Output(){}
        public Output(Object value){
            this.value = value;
        }

        public Object getValue() {
            return value;
        }
    }

    private class MathRequest {
        private Object input = null;
        private Object output = null;

        public MathRequest(Object input, Object output){
            this.input = input;
            this.output = output;
        }

        public Object getInput() {
            return input;
        }

        public Object getOutput() {
            return output;
        }
    }

    @CrossOrigin
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/expression", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
    public ResponseEntity<MathRequest> expression(@RequestBody(required = false) Input input,
                                                  @RequestParam(value="input", defaultValue = "") String value){
        if (input == null){
            input = new Input(value);
        }
        input.setInput(value); // Note: will only set if input's input is null
        String[] inputs = input.getValue().split(",");
        if (inputs.length > 1){
            List<MathRequest> requests = new ArrayList<>(inputs.length);
            for (String s : inputs){
                requests.add(new MathRequest(Engine.fixSyntax(s), Engine.toExpression(s)));
            }
            return new ResponseEntity<>(new MathRequest(input.getValue(), requests), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MathRequest(Engine.fixSyntax(input.getValue()), Engine.toExpression(input.getValue())), HttpStatus.OK);
    }
    @CrossOrigin
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/expression/evaluate", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
    public ResponseEntity<MathRequest> evaluate(@RequestBody(required = false) Input input,
                                                @RequestParam(value="input", defaultValue = "") String value){
        if (input == null){
            input = new Input(value);
        }
        input.setInput(value); // Note: will only set if input's input is null
        String[] inputs = input.getValue().split(",");
        if (inputs.length > 1){
            List<MathRequest> requests = new ArrayList<>(inputs.length);
            for (String s : inputs){
                requests.add(new MathRequest(Engine.fixSyntax(s), Engine.toExpression(s).evaluate()));
            }
            return new ResponseEntity<>(new MathRequest(input.getValue(), requests), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MathRequest(Engine.fixSyntax(input.getValue()), Engine.toExpression(input.getValue()).evaluate()), HttpStatus.OK);
    }
    @CrossOrigin
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/expression/simplify", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
    public ResponseEntity<MathRequest> simplify(@RequestBody(required = false) Input input,
                                                @RequestParam(value="input", defaultValue = "") String value){
        if (input == null){
            input = new Input(value);
        }
        input.setInput(value); // Note: will only set if input's input is null
        String[] inputs = input.getValue().split(",");
        if (inputs.length > 1){
            List<MathRequest> requests = new ArrayList<>(inputs.length);
            for (String s : inputs){
                requests.add(new MathRequest(Engine.fixSyntax(s), Engine.toExpression(s).simplify()));
            }
            return new ResponseEntity<>(new MathRequest(input.getValue(), requests), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MathRequest(Engine.fixSyntax(input.getValue()), Engine.toExpression(input.getValue()).simplify()), HttpStatus.OK);
    }
    @CrossOrigin
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/expression/fraction", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
    public ResponseEntity<MathRequest> fraction(@RequestBody(required = false) Input input,
                                                @RequestParam(value="input", defaultValue = "") String value){
        if (input == null){
            input = new Input(value);
        }
        input.setInput(value); // Note: will only set if input's input is null
        String[] inputs = input.getValue().split(",");
        if (inputs.length > 1){
            List<MathRequest> requests = new ArrayList<>(inputs.length);
            for (String s : inputs){
                requests.add(new MathRequest(Engine.fixSyntax(s), Engine.toExpression(s).toRational()));
            }
            return new ResponseEntity<>(new MathRequest(input.getValue(), requests), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MathRequest(Engine.fixSyntax(input.getValue()), Engine.toExpression(input.getValue()).toRational()), HttpStatus.OK);
    }
    @CrossOrigin
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/expression/valueOf", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
    public ResponseEntity<MathRequest> valueOf(@RequestBody(required = false) Input input,
                                                @RequestParam(value="input", defaultValue = "") String value){
        if (input == null){
            input = new Input(value);
        }
        input.setInput(value); // Note: will only set if input's input is null
        String[] inputs = input.getValue().split(",");
        if (inputs.length > 1){
            List<MathRequest> requests = new ArrayList<>(inputs.length);
            for (String s : inputs){
                requests.add(new MathRequest(Engine.fixSyntax(s), Engine.toExpression(s).valueOf()));
            }
            return new ResponseEntity<>(new MathRequest(input.getValue(), requests), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MathRequest(Engine.fixSyntax(input.getValue()), new Output(Engine.toExpression(input.getValue()).valueOf())), HttpStatus.OK);
    }

//    @CrossOrigin
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/expression/evaluate", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
//    public ResponseEntity<MathRequest> evaluateExpression(@RequestBody(required = false) Input input,
//                                                          @RequestParam(value="input", defaultValue = "") String string){
//        if (input == null){
//            input = new Input(string);
//        }
//        input.setInput(string); // Note: will only set if input's input is null
//        return new ResponseEntity<>(new MathRequest(input, new Evaluated(input)), HttpStatus.OK);
//    }
//
//    private class EvaluatedTeX {
//        private String inTeX = null;
//        private String outTeX = null;
//
//        public EvaluatedTeX(){}
//        public EvaluatedTeX(Input input){
//            Expression e = Engine.toExpression(input.getValue());
//            this.inTeX = e.toTeX();
//            this.outTeX = e.evaluate().toTeX();
//        }
//
//        public String getInTeX() {
//            return inTeX;
//        }
//
//        public String getOutTeX() {
//            return outTeX;
//        }
//    }
//    @CrossOrigin
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/expression/tex/evaluate", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
//    public ResponseEntity<MathRequest> evaluateTeX(@RequestBody(required = false) Input input,
//                                                   @RequestParam(value="input", defaultValue = "") String string){
//        if (input == null){
//            input = new Input(string);
//        }
//        input.setInput(string); // Note: will only set if input's input is null
//        return new ResponseEntity<>(new MathRequest(input, new EvaluatedTeX(input)), HttpStatus.OK);
//    }
//
//    private class ConvertToTeX {
//        private String value = null;
//
//        public ConvertToTeX(){}
//        public ConvertToTeX(Input input){
//            this.value = Engine.toExpression(input.getValue()).toTeX();
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//    }
//    @CrossOrigin
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/expression/tex", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
//    public ResponseEntity<MathRequest> convertToTeX(@RequestBody(required = false) Input input,
//                                                    @RequestParam(value="input", defaultValue = "") String string){
//        if (input == null){
//            input = new Input(string);
//        }
//        input.setInput(string); // Note: will only set if input's input is null
//        return new ResponseEntity<>(new MathRequest(input, new ConvertToTeX(input)), HttpStatus.OK);
//    }
//
//    private class ConvertToFraction {
//        private String value = null;
//        private String outTeX = null;
//
//        public ConvertToFraction(){}
//        public ConvertToFraction(Input input){
//            Expression e = Engine.toExpression(input.getValue()).evaluate().toRational();
//            this.value = e.infix();
//            this.outTeX = e.toTeX();
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        public String getOutTeX() {
//            return outTeX;
//        }
//    }
//    @CrossOrigin
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/expression/fraction", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
//    public ResponseEntity<MathRequest> convertToFraction(@RequestBody(required = false) Input input,
//                                                         @RequestParam(value="input", defaultValue = "") String string){
//        if (input == null){
//            input = new Input(string);
//        }
//        input.setInput(string); // Note: will only set if input's input is null
//        return new ResponseEntity<>(new MathRequest(input, new ConvertToFraction(input)), HttpStatus.OK);
//    }

//    private class ExpressionRequest {
//        private String inTeX = null;
//        private String fracTeX = null;
//        private String outTeX = null;
//
//        public ExpressionRequest(){}
//        public ExpressionRequest(Input input){
//            Expression e = Engine.expression(input.getValue());
//            this.inTeX = e.toTeX();
//            e = e.evaluate();
//            this.fracTeX = e.toRational().toTeX();
//            this.outTeX = e.toTeX();
//        }
//
//        public String getInTeX() {
//            return inTeX;
//        }
//
//        public String getFracTeX() {
//            return fracTeX;
//        }
//
//        public String getOutTeX() {
//            return outTeX;
//        }
//    }
//    @CrossOrigin
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/expression", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
//    public ResponseEntity<MathRequest> expressionRequest(@RequestBody(required = false) Input input,
//                                                         @RequestParam(value="input", defaultValue = "") String string){
//        if (input == null){
//            input = new Input(string);
//        }
//        input.setInput(string); // Note: will only set if input's input is null
//        return new ResponseEntity<>(new MathRequest(input, new ExpressionRequest(input)), HttpStatus.OK);
//    }

}
