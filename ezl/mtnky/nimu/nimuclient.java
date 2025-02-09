package ezl.mtnky.nimu;

import ezl.mtnky.nimu.features.AutoGG;
import ezl.mtnky.nimu.features.AutoVoid;
import ezl.mtnky.nimu.features.Tracker;
import ezl.mtnky.nimu.fig.Luna;
import ezl.mtnky.nimu.fig.ModConfig;
import ezl.mtnky.nimu.fig.mods.FPSdisplay;
import ezl.mtnky.nimu.fig.mods.VOIDdisplay;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

@Mod(
   modid = "nimuclient",
   name = "2muu_Client",
   version = "1.0",
   acceptedMinecraftVersions = "[1.8.9]",
   clientSideOnly = true
)
public class nimuclient {
   public static int voids;
   private static final KeyBinding openConfigKey = new KeyBinding("GUI", 36, "にむくらいあんと！");
   public static Map<String, String> capeData;
   private static boolean unti;
   public static Minecraft mc = Minecraft.getMinecraft();
   public static String[] capes = new String[]{"1", "2", "3"};
   public static List<ResourceLocation> loadedCapes = new ArrayList();
   private static final String GIST_URL = "https://gist.githubusercontent.com/mtnkay/61d90452719f98b4d9aa11a8bab3455f/raw/0fade42d3b121d7826e1154c63176f52ff1db6b6/2muuClientCape.txt";

   public static int findIndex(String[] array, String target) {
      for(int i = 0; i < array.length; ++i) {
         if (array[i].equalsIgnoreCase(target)) {
            return i;
         }
      }

      return -1;
   }

   @SubscribeEvent
   public void onClientTick(ClientTickEvent event) {
      if (event.phase == Phase.END) {
         Display.setTitle("にむくらいあんと [1.8.9] - FPS: " + Minecraft.getDebugFPS());
      }

      if (mc.currentScreen instanceof GuiMainMenu && MainMenu.MainTheme) {
         mc.displayGuiScreen(new MainMenu());
      }

      if (mc.currentScreen instanceof GuiMainMenu && !MainMenu.MainTheme) {
         mc.displayGuiScreen(new MainMenu());
      }

      if (mc.currentScreen instanceof MainMenu && !MainMenu.MainTheme) {
         mc.displayGuiScreen(new MainMenu.MainMenuTwo());
      }

   }

   @EventHandler
   public void preinitz(FMLPreInitializationEvent e) {
   }

   @EventHandler
   public void initz(FMLInitializationEvent event) {
      MinecraftForge.EVENT_BUS.register(this);
      voids = 0;
      MinecraftForge.EVENT_BUS.register(new Tracker());
      MinecraftForge.EVENT_BUS.register(new AutoVoid());
      MinecraftForge.EVENT_BUS.register(new AutoGG());
      ClientRegistry.registerKeyBinding(openConfigKey);
      loadCapes();
      MinecraftForge.EVENT_BUS.register(new FPSdisplay());
      MinecraftForge.EVENT_BUS.register(new VOIDdisplay());
   }

   @SubscribeEvent
   public void onKeyInput(KeyInputEvent event) {
      if (openConfigKey.isPressed()) {
         Minecraft.getMinecraft().displayGuiScreen(new Luna());
      }

   }

   public static void loadCapes() {
      try {
         String[] var0 = capes;
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            String name = var0[var2];
            InputStream stream = nimuclient.class.getResourceAsStream("/assets/minecraft/cape/" + name + ".png");
            if (stream != null) {
               BufferedImage bufferedImage = ImageIO.read(stream);
               loadedCapes.add(mc.renderEngine.getDynamicTextureLocation(name, new DynamicTexture(bufferedImage)));
               System.out.println("[Caped] Added 1 cape.");
            }
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }

   @SubscribeEvent
   public void Tic(ClientTickEvent e) {
      if (Minecraft.getMinecraft().thePlayer != null) {
         if (ModConfig.sprint) {
            KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode(), true);
            unti = false;
         }

         if (!ModConfig.sprint) {
            if (!unti) {
               KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode(), Keyboard.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode()));
               Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Off"));
            }

            unti = true;
         }

      }
   }
}
