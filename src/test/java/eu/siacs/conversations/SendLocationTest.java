package eu.siacs.conversations;

import android.net.Uri;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import eu.siacs.conversations.entities.Conversation;
import eu.siacs.conversations.services.XmppConnectionService;
import static org.junit.Assert.*;

public class SendLocationTest {

    @Mock
    private XmppConnectionService mXmppConnectionService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private Conversation conversation = new Conversation(
            "uuid",
            "test",
            "contact",
            "accoount",
            null,
            System.currentTimeMillis(),
            0,
            0,
            ""
    );

    @Test
    public void testShareLocation() {
        String currentLocation = "geo:1.23,123.4";
        mXmppConnectionService.attachLocationToConversation(
                conversation,
                Uri.parse(currentLocation),
                null
        );

        assertTrue(conversation.getLatestMessage().isGeoUri());
    }
}
