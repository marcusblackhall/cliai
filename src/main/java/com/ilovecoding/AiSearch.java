package com.ilovecoding;

import com.ilovecoding.aicli.FetchData;
import com.ilovecoding.aicli.model.AiRequest;
import com.ilovecoding.aicli.model.AiRequestBuilder;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "aisearch",
        header = {"""   
                            
                   █████████           █████           █████████    ███\s
                  ███░░░░░███         ░░███           ███░░░░░███  ░░░ \s
                 ░███    ░███   █████  ░███ █████    ░███    ░███  ████\s
                 ░███████████  ███░░   ░███░░███     ░███████████ ░░███\s
                 ░███░░░░░███ ░░█████  ░██████░      ░███░░░░░███  ░███\s
                 ░███    ░███  ░░░░███ ░███░░███     ░███    ░███  ░███\s
                 █████   █████ ██████  ████ █████    █████   █████ █████
                ░░░░░   ░░░░░ ░░░░░░  ░░░░ ░░░░░    ░░░░░   ░░░░░ ░░░░░\s
                                                                       \s
                """


        },

        mixinStandardHelpOptions = true,
        version = "1.0.0", showDefaultValues = true,
        description = "Call the @|bold,underline ChatGpt API|@ and @|fg(red) display|@ response"
)
public class AiSearch implements Callable<Integer> {

    @CommandLine.Option(names = {"-p", "--prompt"}, required = true)
    private String prompt;

    @CommandLine.Option(names = {"-t", "--maxTokens"}, required = true, defaultValue = "150", type = Integer.class)
    private Integer maxTokens;

    @CommandLine.Option(names = {"-m", "--model"}, defaultValue = "text-davinci-003")
    String model;

    @CommandLine.Option(names = {"-pen", "--penalty"}, defaultValue = "0.0")
    private Double prescencePenalty;

    @CommandLine.Option(names = {"-topP", "--topP"}, defaultValue = "1.0")
    private Double topP;


    @CommandLine.Option(names = {"-f", "--frequency"}, defaultValue = "0.0")
    private Double frequencyPenalty;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public Integer call() throws Exception {

        String[] banner = spec.usageMessage().header();
        for (String line : banner) {
            System.out.println(CommandLine.Help.Ansi.AUTO.string(line));
        }

        return new FetchData().execute(prepareRequest());

    }

    private AiRequest prepareRequest() {

        return new AiRequestBuilder().setModel(model)
                .setPrompt(prompt)
                .setMaxTokens(maxTokens)
                .setPresencePenalty(prescencePenalty)
                .setFrequencyPenalty(frequencyPenalty)
                .setTopP(topP)
                .createAiRequest();


    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new AiSearch()).execute(args);
        System.exit(exitCode);
    }


}
