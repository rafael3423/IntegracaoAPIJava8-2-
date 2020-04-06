//String roomChaveId = "";
//            String roomNameId = "";
//            String vlCadaQuarto = "";
//            LinkedHashMap<String, Integer> quartoConfig = new LinkedHashMap<>();
//            for (Room room : packagesResult.getRooms()) { //Iteração de quartos requisitados
//
//                Integer qtQuarto = quartoConfig.get(room.getRoomName());
//                if (qtQuarto == null) {
//                    quartoConfig.put(room.getRoomName(), 1);
//                } else {
//                    qtQuarto++;
//                    quartoConfig.replace(room.getRoomName(), qtQuarto);
//                }
//
//                if (roomChaveId.equalsIgnoreCase("")) {
//                    roomChaveId = room.getId();
//                    roomNameId = room.getRoomName();
//                    vlCadaQuarto = room.getPrice().getCurrency() + "%" + room.getPrice().getFinalPrice();
//                } else {
//                    roomChaveId += "#" + room.getId();
//                    roomNameId += "#" + room.getRoomName();
//                    vlCadaQuarto += "#" + room.getPrice().getCurrency() + "%" + room.getPrice().getFinalPrice();
//                }
//
//            }
//
//            String textoQuarto = null;
//            for (Map.Entry<String, Integer> quarto : quartoConfig.entrySet()) {
//                if (textoQuarto == null) {
//                    textoQuarto = quarto.getValue() + "x " + quarto.getKey();
//                } else {
//                    textoQuarto = textoQuarto + "+ " + quarto.getValue() + "x " + quarto.getKey();
//                }
//            }
//
//            ParQuarto parQuarto = (ParQuarto) UtilsWS.converteJsonToObject(hotelPesquisa.getQuartoList().get(0).getQuartoUhList().get(0).getUh().getDsParametro(), ParQuarto.class);
//            parQuarto.setA1(packagesResult.getPackageId());
//            parQuarto.setA3(roomChaveId);
//            parQuarto.setA4(textoQuarto);
//            parQuarto.setA0(hotelPesquisa.getDsParametro());
//            parQuarto.setA5(roomNameId);
//            parQuarto.setA6(vlCadaQuarto);
//
//
//
//
//Digite aqui
