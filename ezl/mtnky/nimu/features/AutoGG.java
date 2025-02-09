package ezl.mtnky.nimu.features;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoGG {
   @SubscribeEvent
   public void gg(ClientChatReceivedEvent e) {
      String A = e.message.getUnformattedText().replaceAll("§([0-9a-f]|r|l|o|n|m|k)", "");
   }
}
