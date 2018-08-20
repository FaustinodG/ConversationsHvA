package eu.siacs.conversations;

import android.net.Uri;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.File;
import java.io.IOException;

import eu.siacs.conversations.entities.Conversation;
import eu.siacs.conversations.services.XmppConnectionService;

public class FileSendTest {

    @Mock
    private XmppConnectionService mXmppConnectionService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private Conversation conversation = new Conversation(
            "UUID",
            "Test Conversation",
            "Contact_UUID",
            "Account_UUID",
            null,
            System.currentTimeMillis(),
            0,
            0,
            ""
    );

    @Test
    public void sendFile() throws IOException {
        File image = File.createTempFile( "asvfile", ".jpg");
        mXmppConnectionService.attachImageToConversation(
                conversation,
                Uri.parse(image.toURI().toString()),
                null
        );
        Mockito.verify(mXmppConnectionService,
                Mockito.times(1)).attachImageToConversation(
                conversation,
                Uri.parse(image.toURI().toString()),
                null
        );
    }


}
