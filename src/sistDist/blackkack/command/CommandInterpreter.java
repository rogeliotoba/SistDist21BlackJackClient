package sistDist.blackkack.command;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CommandInterpreter
{
    public static Command getCommand(String metadata)
    {
        Command cmd = null;
        JSONParser parser = new JSONParser();
        ContainerFactory containerFactory = new ContainerFactory()
        {
            @Override
            public List creatArrayContainer()
            {
                return new LinkedList();
            }

            @Override
            public Map createObjectContainer()
            {
                return new LinkedHashMap();
            }
        };

        try
        {
            Map json = (Map) parser.parse(metadata, containerFactory);
            Iterator iter = json.entrySet().iterator();
            while (iter.hasNext())
            {
                Map.Entry entry = (Map.Entry) iter.next();
                if (entry.getKey().equals("commandType"))
                {
                    String type = entry.getValue().toString();
                    switch (type)
                    {
                        case "AcceptCard":
                            cmd = new AcceptCardCommand();
                            break;
                        case "AssignCard":
                            cmd = new AssignCardCommand();
                            break;
                        case "ChangeTurnCommand":
                            cmd = new ChangeTurnCommand();
                            break;
                        case "GameFinished":
                            cmd = new GameFinishedCommand();
                            break;
                        case "PlayerLoose":
                            cmd = new PlayerLooseCommand();
                            break;
                        case "PlayerWin":
                            cmd = new PlayerWinCommand();
                            break;
                        case "Register":
                            cmd = new RegisterCommand();
                            break;
                        case "StopCards":
                            cmd = new StopCardsCommand();
                            break;
                    }
                    break;
                }
            }
        } catch (ParseException pe)
        {
            System.out.println(pe);
        }

        return cmd;
    }

    public static String getAttribute(String metadata, String attribute)
    {
        String result = "";
        JSONParser parser = new JSONParser();
        ContainerFactory containerFactory = new ContainerFactory()
        {
            public List creatArrayContainer()
            {
                return new LinkedList();
            }

            public Map createObjectContainer()
            {
                return new LinkedHashMap();
            }
        };

        try
        {
            Map json = (Map) parser.parse(metadata, containerFactory);
            Iterator iter = json.entrySet().iterator();
            while (iter.hasNext())
            {
                Map.Entry entry = (Map.Entry) iter.next();
                if (entry.getKey().equals(attribute))
                {
                    result = entry.getValue().toString();
                    break;
                }
            }
        } catch (ParseException pe)
        {
            System.out.println(pe);
        }
        return result;
    }
}
