package eu.siacs.conversations;

import android.net.Uri;

import org.junit.Rule;
import org.mockito.Mock;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.File;
import java.io.IOException;

import eu.siacs.conversations.entities.Conversation;
import eu.siacs.conversations.services.XmppConnectionService;

public class SendVoiceTest {



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
    public void testSendVoiceMessages() throws IOException {
        File voiceMessage = File.createTempFile( "message", ".mp3");
        mXmppConnectionService.attachFileToConversation(
                conversation,
                Uri.parse(voiceMessage.toURI().toString()),
                null,
                null
        );
        Mockito.verify(mXmppConnectionService,
                Mockito.times(1)).attachFileToConversation(
                conversation,
                Uri.parse(voiceMessage.toURI().toString()),
                null,
                null
        );
    }

}
