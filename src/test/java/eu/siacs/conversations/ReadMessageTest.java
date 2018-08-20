package eu.siacs.conversations;

import org.junit.Test;

import eu.siacs.conversations.entities.Conversation;
import eu.siacs.conversations.entities.Message;

import static org.junit.Assert.*;


public class ReadMessageTest {

    private Conversation conversation = new Conversation(
            "uuid",
            "test",
            "contact",
            "account",
            null,
            System.currentTimeMillis(),
            0,
            0,
            ""
    );


    @Test
    public void readMessageTest() {
        Message message = new Message(
                conversation,
                "Test Message",
                0
        );
        conversation.add(message);
        assertTrue(conversation.getLatestMessage().isRead());
    }

}
