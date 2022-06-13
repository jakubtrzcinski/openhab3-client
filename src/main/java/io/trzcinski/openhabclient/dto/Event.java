package io.trzcinski.openhabclient.dto;

import lombok.*;

import java.util.Map;

/**
 * @author Jakub Trzcinski jakub@trzcinski.io
 * @since 12-06-2022
 */
@Getter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
public class Event {
    private final String topic;
    private final Payload payload;
    private final Type type;

    public enum Type{
        ThingStatusInfoEvent,
        RuleStatusInfoEvent,
        ItemCommandEvent,
        ItemStateEvent,
        ItemStatePredictedEvent,
        ItemStateChangedEvent,
        InboxUpdatedEvent
    }

    @Data
    @EqualsAndHashCode
    public static class Payload {
        private Status status;
        private StatusDetail statusDetail;
        private Type type;
        private Object value;

        public enum Status{
            IDLE,
            RUNNING
        }
        public enum StatusDetail{
            NONE
        }
        public enum Type{
            OnOff
        }
    }
}

