package eu.siacs.conversations;

import android.support.annotation.NonNull;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import eu.siacs.conversations.entities.Account;
import eu.siacs.conversations.services.XmppConnectionService;
import rocks.xmpp.addr.Jid;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class DisableAccountTest {


    @Mock
    private XmppConnectionService mXmppConnectionService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    Jid jid = new Jid() {
        @Override
        public boolean isFullJid() {
            return false;
        }

        @Override
        public boolean isBareJid() {
            return false;
        }

        @Override
        public Jid asBareJid() {
            return null;
        }

        @Override
        public Jid withLocal(CharSequence local) {
            return null;
        }

        @Override
        public Jid withResource(CharSequence resource) {
            return null;
        }

        @Override
        public Jid atSubdomain(CharSequence subdomain) {
            return null;
        }

        @Override
        public String getLocal() {
            return null;
        }

        @Override
        public String getEscapedLocal() {
            return null;
        }

        @Override
        public String getDomain() {
            return null;
        }

        @Override
        public String getResource() {
            return null;
        }

        @Override
        public String toEscapedString() {
            return null;
        }

        @Override
        public int length() {
            return 0;
        }

        @Override
        public char charAt(int index) {
            return 0;
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return null;
        }

        @Override
        public int compareTo(@NonNull Jid o) {
            return 0;
        }
    };

    @Test
    public void testDisableAccount(){
        Account account = new Account(
                jid,
                "123456"
        );

        account.setOption(Account.OPTION_DISABLED, true);
        mXmppConnectionService.updateAccount(account);
        assertTrue(account.isOptionSet(Account.OPTION_DISABLED));
    }
}
