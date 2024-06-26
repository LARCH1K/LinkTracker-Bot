package edu.java.bot.api.scrapper.controller;

import com.pengrad.telegrambot.model.request.ParseMode;
import edu.java.bot.api.scrapper.dto.request.UpdateDto;
import edu.java.bot.api.scrapper.dto.response.ErrorResponseDto;
import edu.java.bot.core.telegram.service.BotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static edu.java.bot.api.scrapper.ApiPath.BOT;
import static edu.java.bot.api.scrapper.ApiPath.UPDATES;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(BOT)
@CrossOrigin(origins = "*")
@Tag(
    name = "api.bot.controller.tag.name",
    description = "api.bot.controller.tag.description"
)
public class BotController {

    private final BotService botService;

    @PutMapping(UPDATES)
    @Operation(summary = "api.bot.endpoint.catch-updates.summary")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "api.response.ok"
        ),
        @ApiResponse(
            responseCode = "400",
            description = "api.bot.endpoint.catch-updates.response.bad-request",
            content = {
                @Content(
                    mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseDto.class)
                )
            }),
        @ApiResponse(
            responseCode = "500",
            description = "api.response.internal-server-error",
            content = {
                @Content(
                    mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseDto.class)
                )
            })
    })

    public ResponseEntity<?> catchUpdates(@Valid @RequestBody List<UpdateDto> updateDtos) {
        botService.sendUpdates(updateDtos, ParseMode.HTML);
        return ResponseEntity.ok().build();
    }

}
