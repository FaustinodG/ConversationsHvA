package eu.siacs.conversations;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import eu.siacs.conversations.entities.Conversation;
import eu.siacs.conversations.services.XmppConnectionService;

import static eu.siacs.conversations.entities.Conversational.MODE_MULTI;
import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.when;

public class GroupConversationsTest {

    @Mock
    private XmppConnectionService mXmppConnectionService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        when(mXmppConnectionService.findOrCreateConversation(
                any(),
                any(),
                anyBoolean(),
                anyBoolean())).thenReturn(Mockito.mock(Conversation.class));
    }

    @Test
    public void testGroup() {
        Conversation conversation = mXmppConnectionService.findOrCreateConversation(
                null,
                null,
                true,
                true);
        assertEquals(MODE_MULTI, conversation.getMode());
    }

}
